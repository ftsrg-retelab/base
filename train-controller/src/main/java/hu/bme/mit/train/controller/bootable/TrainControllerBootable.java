package hu.bme.mit.train.controller.bootable;

import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.kernel.Bootable;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerBootable implements Bootable {

	final ActorSystem system = ActorSystem.create("Train");

	@Override
	public void startup() {
		final TrainController trainController = TypedActor.get(system)
				.typedActorOf(new TypedProps<TrainController>(TrainController.class, () -> new TrainControllerImpl()), "controller");
	}

	@Override
	public void shutdown() {
		system.terminate();
	}

}
