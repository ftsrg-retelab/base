#!/bin/bash

for module in controller sensor user; do
  cp train-$module/build/libs/*-fat.jar akka-microkernel-$module/lib/
done
