package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by robotics on 11/13/2015.
 */
public class  JoannaAutonomousRed extends LinearOpMode {
    DcMotor rightTread1;//front right
    DcMotor rightTread2;
    DcMotor leftTread1;//back right
    DcMotor leftTread2;
    DcMotor arm1;
    DcMotor arm2;
    Servo wacker1;
    Servo wacker2;
    @Override
    public void runOpMode()throws InterruptedException{
        rightTread1 = hardwareMap.dcMotor.get("rightTread1");
        rightTread2 = hardwareMap.dcMotor.get("rightTread2");
        leftTread1 = hardwareMap.dcMotor.get("leftTread1");
        leftTread2 = hardwareMap.dcMotor.get("leftTread2");
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");
        wacker1 = hardwareMap.servo.get("wacker1");
        wacker2 = hardwareMap.servo.get("wacker2");
        rightTread1.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        rightTread2.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        leftTread1.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        leftTread2.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        arm1.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        arm2.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

            rightTread1.setPower(1);
            leftTread1.setPower(-1);
            rightTread2.setPower(1);
            leftTread2.setPower(-1);
            Thread.sleep(3077);
        //turn to face mountain

            leftTread1.setPower(1);
            rightTread1.setPower(1);
            leftTread2.setPower(1);
            rightTread2.setPower(1);
            Thread.sleep(1000);

        //drive up mountain
            rightTread1.setPower(1);
            leftTread1.setPower(-1);
            rightTread2.setPower(1);
            leftTread2.setPower(-1);
            Thread.sleep(3077);

            rightTread1.close();
            leftTread1.close();
            rightTread2.close();
            leftTread2.close();
        }
    }


