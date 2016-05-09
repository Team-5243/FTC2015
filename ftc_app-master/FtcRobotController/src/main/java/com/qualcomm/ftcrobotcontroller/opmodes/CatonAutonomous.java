package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by CvilleRobotics-2 on 11/18/2015.
 */
public class CatonAutonomous extends LinearOpMode {
    DcMotor leftTread;
    DcMotor rightTread;
    @Override
    public void runOpMode() throws InterruptedException{
        leftTread = hardwareMap.dcMotor.get("leftTread");
        rightTread = hardwareMap.dcMotor.get("rightTread");
        leftTread.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightTread.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        leftTread.setPower(1);
        rightTread.setPower(1);
        Thread.sleep(3620);
        leftTread.setPower(-1);
        rightTread.setPower(1);
        Thread.sleep(500);
        leftTread.setPower(1);
        rightTread.setPower(1);
        Thread.sleep(3620);
    }

}
