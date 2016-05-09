package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.Override;

public class BaseTankDrive extends OpMode {
    DcMotor rightTread;//front right
    DcMotor leftTread;//back right
    DcMotor arm;
    @Override
    public void init() {
        rightTread = hardwareMap.dcMotor.get("rightTread");
        leftTread = hardwareMap.dcMotor.get("leftTread");
        arm = hardwareMap.dcMotor.get("fancyArm");
    }
    @Override
    public void loop() {
        rightTread.setPower(gamepad1.right_stick_y);
        leftTread.setPower(-gamepad1.left_stick_y);

        if (gamepad1.left_bumper) {
            arm.setPower(-gamepad1.left_trigger);
        }
        else {
            arm.setPower(gamepad1.left_trigger);
        }

    }
    @Override
    public void init_loop() {
        rightTread.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        leftTread.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        arm.setChannelMode((DcMotorController.RunMode.RUN_WITHOUT_ENCODERS));
    }
}
