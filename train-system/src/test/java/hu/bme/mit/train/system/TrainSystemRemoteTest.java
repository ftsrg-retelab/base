package hu.bme.mit.train.system;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Terminated;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class TrainSystemRemoteTest {

	final ActorSystem actorSystem = ActorSystem.create("TrainClient");

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;

	private ActorRef lookupActor(String ip, int port, String name) {
		final ActorSelection selection = actorSystem.actorSelection(String.format("akka.tcp://Train@%s:%d/user/%s", ip, port, name));
		final Future<ActorRef> resolveOne = selection.resolveOne(Duration.create(5, TimeUnit.SECONDS));
		final ActorRef actorRef;
		try {
			actorRef = Await.result(resolveOne, Duration.create(5, TimeUnit.SECONDS));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return actorRef;
	}

	@Before
	public void before() {
		final ActorRef actorRef = lookupActor(System.getenv("TRAIN_CONTROLLER_IP"), 2553, "controller");
		controller = TypedActor.get(actorSystem).typedActorOf(new TypedProps<TrainController>(TrainController.class), actorRef);
		final ActorRef actorRefSensor = lookupActor(System.getenv("TRAIN_SENSOR_IP"), 2554, "sensor");
		sensor = TypedActor.get(actorSystem).typedActorOf(new TypedProps<TrainSensor>(TrainSensor.class), actorRefSensor);
		final ActorRef actorRefUser = lookupActor(System.getenv("TRAIN_USER_IP"), 2555, "user");
		user = TypedActor.get(actorSystem).typedActorOf(new TypedProps<TrainUser>(TrainUser.class), actorRefUser);
	}

	@After
	public void after() throws Exception {
		final Future<Terminated> terminated = actorSystem.terminate();
		Await.result(terminated, Duration.create(5, TimeUnit.SECONDS));
	}

	@Test
	public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
		sensor.overrideSpeedLimit(10);

		Assert.assertEquals(0, controller.getReferenceSpeed());

		user.overrideJoystickPosition(5);

		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
	}

	@Test
	public void OverridingJoystickPositionToNegative_SetsReferenceSpeedToZero() {
		user.overrideJoystickPosition(4);
		controller.followSpeed();
		user.overrideJoystickPosition(-5);
		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

}
