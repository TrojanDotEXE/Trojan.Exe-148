package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    OpMode opMode;
    CRServo slider1, slider2;
    Servo arm1, arm2, claw1, claw2;
    public Intake(@NonNull OpMode opMode){
        this.opMode = opMode;
    }

    public void init(){

        slider1 = opMode.hardwareMap.get(CRServo.class, "intake1");
//        slider2 = opMode.hardwareMap.get(CRServo.class, "intake2");
//        arm1 = opMode.hardwareMap.get(Servo.class, "intakeArm1");
//        arm2 = opMode.hardwareMap.get(Servo.class, "intakeArm2");
//        claw1 = opMode.hardwareMap.get(Servo.class, "claw1");
//        claw2 = opMode.hardwareMap.get(Servo.class, "claw2");
//
        slider1.setDirection(DcMotorSimple.Direction.FORWARD);
//        slider2.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        arm1.setPosition(0);
//        arm2.setPosition(0);
//        claw1.setPosition(0);
//        claw2.setPosition(0);
        slider1.setPower(0);
//        slider2.setPower(0);
    }

    public void extend (Gamepad gamepad){
        double power = -gamepad.left_stick_y;

            slider1.setPower(power);
//            slider2.setPower(power);

    }

    public void claw (Gamepad gamepad){

        if (gamepad.left_bumper) {

            claw1.setPosition(1);
            claw2.setPosition(-1);

        }
        claw1.setPosition(0);
        claw2.setPosition(0); // da
    }

    public void arm (Gamepad gamepad){

        if (gamepad.left_trigger > 0) {

            arm1.setPosition(1);
            arm2.setPosition(-1);

        }
        arm1.setPosition(0);
        arm2.setPosition(0);
    }
}
