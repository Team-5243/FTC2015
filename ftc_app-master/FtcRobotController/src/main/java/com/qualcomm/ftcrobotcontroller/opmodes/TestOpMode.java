package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.Override;

public class TestOpMode extends OpMode {
    DcMotor unlovedChild;//front left
    DcMotor orphan;//back left
    DcMotor philIsGod;//front right
    DcMotor shrek;//back right
    Servo pleblord;//arm servo
    @Override
    public void init() {
        unlovedChild = hardwareMap.dcMotor.get("motor1");
        orphan = hardwareMap.dcMotor.get("motor2");
        philIsGod = hardwareMap.dcMotor.get("motor3");
        shrek = hardwareMap.dcMotor.get("motor4");
        pleblord = hardwareMap.servo.get("servo1");
    }

    @Override
    public void loop() {
        if(gamepad1.right_bumper){
            pleblord.setPosition(.5);
        }
        else if(gamepad1.left_bumper){
            pleblord.setPosition(0);
        }
        if (gamepad1.a) {
            unlovedChild.setPower(1.0);
            orphan.setPower(1.0);
            philIsGod.setPower(1.0);
            shrek.setPower(1.0);
        }
        else
            unlovedChild.setPower(gamepad1.left_stick_y);
            orphan.setPower(gamepad1.left_stick_y);
            philIsGod.setPower(gamepad1.right_stick_y);
            shrek.setPower(gamepad1.right_stick_y);
    }
    @Override
    public void init_loop(){
        unlovedChild.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        orphan.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        philIsGod.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        shrek.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }
}
