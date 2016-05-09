package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import java.lang.Override;

public class FatimaOpMode extends OpMode {
    DcMotor rightTread;//name says all
    DcMotor leftTread;//name says all
    Servo susan; // lazy SUSAN ISA VEX MOTA
    Servo teeteringArm; // on top of the lazy susan, it moves up and down, the bristles are on its end, to pull stuff up
    DcMotor bristles; // on the end of the arm, to bring stuff in
    @Override
    public void init() {
        rightTread = hardwareMap.dcMotor.get("rightTread");
        leftTread = hardwareMap.dcMotor.get("leftTread");
        susan = hardwareMap.servo.get("lazySusan");
        //teeteringArm = hardwareMap.servo.get("teeteringArm");
        //bristles = hardwareMap.dcMotor.get("bristles");
    }
    @Override
    public void loop() {
        rightTread.setPower(gamepad1.right_stick_y);
        leftTread.setPower(gamepad1.left_stick_y);

        /*if(gamepad1.y) {
            bristles.setPower(1);
        }
        else if(gamepad1.a) {
            bristles.setPower(-1);
        }else if(gamepad1.x || gamepad1.b) {
            bristles.setPower(0);
        }*/
        VMM();


    }
    @Override
    public void init_loop(){
        rightTread.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        leftTread.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
       // bristles.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }
    public void SSM(){
        if(gamepad1.left_bumper){
            teeteringArm.setPosition(Range.clip(teeteringArm.getPosition()+gamepad1.left_trigger,0,1));
        }else{
            teeteringArm.setPosition(Range.clip(teeteringArm.getPosition()-gamepad1.left_trigger,0,1));
        }
    }
    public void VMM(){
        if(gamepad1.left_bumper){
            susan.setDirection(Servo.Direction.FORWARD);
            susan.setPosition(0);
        }else if(gamepad1.left_trigger >= .05){
            susan.setDirection(Servo.Direction.REVERSE);
            susan.setPosition(0);
        }else{
            susan.setPosition(.5);
        }
    }

}
