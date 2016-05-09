package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.Override;
public class JoannaOpMode extends OpMode {
    DcMotor rightTread1;//front right
    DcMotor rightTread2;
    DcMotor leftTread1;//back right
    DcMotor leftTread2;
    DcMotor arm1;
    DcMotor arm2;
    Servo wacker1;
    Servo wacker2;
    int controller = 1;
    @Override
    public void init() {
        rightTread1 = hardwareMap.dcMotor.get("rightTread1");
        rightTread2 = hardwareMap.dcMotor.get("rightTread2");
        leftTread1 = hardwareMap.dcMotor.get("leftTread1");
        leftTread2 = hardwareMap.dcMotor.get("leftTread2");
        arm1 = hardwareMap.dcMotor.get("arm1");
        arm2 = hardwareMap.dcMotor.get("arm2");
        wacker1 = hardwareMap.servo.get("wacker1");
        wacker2 = hardwareMap.servo.get("wacker2");
    }
    @Override
    public void loop() {
        leftTread1.setPower(0);
        leftTread2.setPower(0);
        rightTread1.setPower(0);
        rightTread2.setPower(0);
        arm1.setPower(0);
        arm2.setPower(0);

        if (gamepad1.dpad_up || gamepad2.dpad_up) {
            if (controller == 1) {
                controller = 2;
            } else {
                controller = 1;
            }
        }
        if (controller == 1) {
            rightTread1.setPower(gamepad1.right_stick_y);
            rightTread2.setPower(-gamepad1.right_stick_y);
            leftTread1.setPower(gamepad1.left_stick_y);
            leftTread2.setPower(gamepad1.left_stick_y);
        } else {
            rightTread1.setPower(gamepad2.right_stick_y);
            rightTread2.setPower(-gamepad2.right_stick_y);
            leftTread1.setPower(gamepad2.left_stick_y);
            leftTread2.setPower(gamepad2.left_stick_y);
        }
        if(controller == 1) {
            if (gamepad1.left_bumper) {
                arm1.setPower(gamepad1.left_trigger);
                arm2.setPower(gamepad1.left_trigger);
            } else {
                arm1.setPower(-gamepad1.left_trigger);
                arm2.setPower(-gamepad1.left_trigger);
            }
        }
        else if(controller == 2) {
            if (gamepad2.left_bumper) {
                arm1.setPower(gamepad2.left_trigger);
                arm2.setPower(gamepad2.left_trigger);
            } else {
                arm1.setPower(-gamepad2.left_trigger);
                arm2.setPower(-gamepad2.left_trigger);
            }
        }
        if (controller == 1) {
            if (gamepad1.x)
                wacker1.setPosition(0.5);
            else if (gamepad1.y)
                wacker1.setPosition(0);
            if (gamepad1.b)
                wacker2.setPosition(1);

            else if (gamepad1.a)
                wacker2.setPosition(0.5);
        }
        else if(controller == 2){
            if (gamepad2.x) {
                wacker1.setPosition(0.5);
            }
            else if (gamepad2.y) {
                wacker1.setPosition(0);
            }
            if (gamepad2.b) {
                wacker2.setPosition(1);
            }
            else if (gamepad2.a)
                wacker2.setPosition(0.5);
        }
    }
    @Override
    public void init_loop() {
        rightTread1.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        rightTread2.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        leftTread1.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        leftTread2.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        arm1.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        arm2.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }
    public void SSM(){
        if(gamepad1.y){
            wacker1.setPosition(0);
        }else if(gamepad1.x){
            wacker1.setPosition(1);
        }
        if(gamepad1.b){
            wacker1.setPosition(1);
        }else if(gamepad1.a){
            wacker1.setPosition(0);
        }
    }
}
