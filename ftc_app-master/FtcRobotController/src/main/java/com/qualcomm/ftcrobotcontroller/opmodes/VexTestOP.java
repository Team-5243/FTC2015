package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.PWMOutput;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.Override;

public class VexTestOP extends OpMode {
    Servo vex;

    @Override
    public void init() {
        vex = hardwareMap.servo.get("vex");
    }

    @Override
    public void loop() {
        //vex.setPosition(.5);
       // vex.setDirection(Servo.Direction.FORWARD);
        if(gamepad1.left_bumper) {
            vex.setDirection(Servo.Direction.REVERSE);
            vex.setPosition(0);
        }else if(gamepad1.right_bumper){
            vex.setDirection(Servo.Direction.FORWARD);
            vex.setPosition(0);
        } else {
            vex.setPosition(.5);
        }
    }
    @Override
    public void init_loop() {

    }
}
