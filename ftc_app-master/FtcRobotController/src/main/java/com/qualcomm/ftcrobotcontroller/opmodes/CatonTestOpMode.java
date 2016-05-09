package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by CvilleRobotics-2 on 12/2/2015.
 */
public class CatonTestOpMode extends OpMode {
    DcMotor test1;
    DcMotor test2;
    @Override
    public void init() {
        test1 = hardwareMap.dcMotor.get("test1");
        test2 = hardwareMap.dcMotor.get("test2");
    }
    @Override
    public void loop() {
        test1.setPower(-gamepad1.left_stick_y);
        test2.setPower(gamepad1.right_stick_y);
    }
    @Override
    public void init_loop() {
        test1.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        test2.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
    }
}
