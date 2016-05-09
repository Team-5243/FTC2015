package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by CvilleRobotics-2 on 11/6/2015.
 */
public class CatonOpMode extends OpMode{

    DcMotor leftTread;
    DcMotor rightTread;
    DcMotor arm;
    Servo lazySusan;

    Servo claw1; // closer servo
    Servo claw2;// farther servo
    @Override
    public void init() {
        leftTread = hardwareMap.dcMotor.get("leftTread");
        rightTread = hardwareMap.dcMotor.get("rightTread");
        arm = hardwareMap.dcMotor.get("arm");
        lazySusan = hardwareMap.servo.get("susan");

        claw1 = hardwareMap.servo.get("claw1");
        claw2 = hardwareMap.servo.get("claw2");
    }

    @Override
    public void loop() {
        leftTread.setPower(gamepad1.left_stick_y);
        rightTread.setPower(-gamepad1.right_stick_y);


        if(gamepad1.b) {
            arm.setPower(-gamepad1.left_trigger);
        }
        else {
            arm.setPower(gamepad1.left_trigger);
        }



        SSM();
        VMM();
    }

    @Override
    public void init_loop() {
        leftTread.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        rightTread.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        arm.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }

    public void SSM() {
        if(gamepad1.a){
            //claw1.setPosition(Range.clip(claw1.getPosition()+.05,0,1));
            //claw2.setPosition(Range.clip(claw2.getPosition()+.05,0,1));
            claw1.setPosition(1);
            claw2.setPosition(0);
        } if(gamepad1.y){
            //claw1.setPosition(Range.clip(claw1.getPosition() - .05, 0, 1));
            //claw2.setPosition(Range.clip(claw2.getPosition()-.05,0,1));
            claw1.setPosition(0);
            claw2.setPosition(1);
        }
    }
    public void VMM(){
        if(gamepad1.left_bumper){
            lazySusan.setDirection(Servo.Direction.FORWARD);
            lazySusan.setPosition(0);
        }else if(gamepad1.right_bumper){
            lazySusan.setDirection(Servo.Direction.REVERSE);
            lazySusan.setPosition(0);
        }else{
            lazySusan.setPosition(.5);
        }
    }
}
