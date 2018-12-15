package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

//Voltage is 13.76 V
@Autonomous (name = "Autonomousv2")

public class Autonomousv2 extends LinearOpMode {
    public ColorSensor Sen1_CS;
    public DcMotor M1_BLW;
    public DcMotor M2_BRW;
    public DcMotor M3_FLS;
    public DcMotor M4_Arm;
    public Servo S1_Basket;
    @Override

    public void runOpMode() throws InterruptedException{

        Sen1_CS = hardwareMap.get(ColorSensor.class, "Sen1_CS");
        M1_BLW = hardwareMap.get(DcMotor.class, "M1_BLW");
        M2_BRW = hardwareMap.get(DcMotor.class, "M2_BRW");
        M3_FLS = hardwareMap.get(DcMotor.class, "M3_FLS");
        M4_Arm = hardwareMap.get(DcMotor.class, "M4_Arm");
        S1_Basket = hardwareMap.get(Servo.class, "S1_Basket");

        waitForStart();
        while(opModeIsActive()) {


            M1_BLW.setDirection(DcMotor.Direction.FORWARD);
            M2_BRW.setDirection(DcMotor.Direction.REVERSE);

            float hsvValues[] = {0F, 0F, 0F};
            final float values[] = hsvValues;
            Color.RGBToHSV(Sen1_CS.red() * 8, Sen1_CS.green() * 8, Sen1_CS.blue() * 8, hsvValues);
            float hue = hsvValues[0];
            float sat = hsvValues[1];
            float val = hsvValues[2];

            telemetry.addData("Hue:", hue);
            telemetry.addData("Saturation:", sat);
            telemetry.addData("Value", val);
            telemetry.update();


            M1_BLW.setPower(.5);
            M2_BRW.setPower(.5);
            sleep(175);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(1);
            M2_BRW.setPower(-1);
            sleep(100);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(1);
            M2_BRW.setPower(1);
            sleep(100);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(1);
            M2_BRW.setPower(.07);
            sleep(500);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            sleep(2000);

            Color.RGBToHSV(Sen1_CS.red() * 8, Sen1_CS.green() * 8, Sen1_CS.blue() * 8, hsvValues);
            hue = hsvValues[0];             //SCANS UNTIL FINDS YELLOW
            sat = hsvValues[1];
            val = hsvValues[2];
             if((hue > 1000 && hue < 135 /*EDIT THIS VALUE */) && (sat > .14 && sat < .28) && (val > .47 && val < .65)){//YELLOW
//hue is 115 - 135


                telemetry.addData("READING","YELLOW");
                telemetry.update();
                M1_BLW.setPower(1);
                M2_BRW.setPower(1);
                sleep(500);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);
               //  M3_FLS.setPower(-1);
                sleep(500);

                M1_BLW.setPower(0.5);
                M2_BRW.setPower(1.0);
                sleep(800);
                M1_BLW.setPower(0.0);
                M2_BRW.setPower(0.0);
                M4_Arm.setPower(-0.5);
                sleep(500);
                M4_Arm.setPower(0.0);
                S1_Basket.setPosition(180);
                sleep(100);

                stop();
            }

            else if((hue > 100 && hue < 120) && (sat > .1 && sat < .27) && (val > .7 && val < 1.2 )){//WHITE
                 //hue 110 - 125 sat 0.17-0.22 val 0.95 - 1.005
                telemetry.addData("READING","WHITE");
                telemetry.update();

                M1_BLW.setPower(0);
                M2_BRW.setPower(-1);
                sleep(800);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);

                M1_BLW.setPower(1);
                M2_BRW.setPower(1);
                sleep(500);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);


                M1_BLW.setPower(0.3);
                M2_BRW.setPower(1.0);
                sleep(345);
                M1_BLW.setPower(0.0);
                sleep(1150);
                M2_BRW.setPower(0.0);
                M1_BLW.setPower(0.7);
                M2_BRW.setPower(1.0);
                sleep(500);
                M2_BRW.setPower(0.0);
                M1_BLW.setPower(0.0);
                M4_Arm.setPower(-0.5);
                sleep(500);
                M4_Arm.setPower(0.0);
                S1_Basket.setPosition(360);
                sleep(100);

                stop();
            }

            else{
                telemetry.addData("READING","NOTHING");
                telemetry.update();
                M1_BLW.setPower(1);
                M2_BRW.setPower(1);
                sleep(500);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);

                M1_BLW.setPower(0.5);
                M2_BRW.setPower(1.0);
                sleep(800);
                M1_BLW.setPower(0.0);
                M2_BRW.setPower(0.0);
                M4_Arm.setPower(-0.5);
                sleep(500);
                M4_Arm.setPower(0.0);
                S1_Basket.setPosition(180);
                sleep(100);

                stop();
            }

            stop();
        }
    }
}

//M1_BLW.setPower(0.5);
  //      M2_BRW.setPower(1.0);
    //    sleep(800);
      //  M1_BLW.setPower(0.0);
        //M2_BRW.setPower(0.0);
        //M4_Arm.setPower(-0.5);
        //sleep(500);
        //M4_Arm.setPower(0.0);
        //S1_Basket.setPosition(180);
        //sleep(100);

//M1_BLW.setPower(0.5);
//M2_BRW.setPower(1.0);
//sleep(800);
//M1_BLW.setPower(0.0);
//M2_BRW.setPower(0.0);
//M4_Arm.setPower(-0.5);
//sleep(500);
//M4_Arm.setPower(0.0);
//S1_Basket.setPosition(180);
//sleep(100);
// M4_Arm.setPower(0.5);
//sleep(200);
//M4_Arm.setPower(0.0);
//S1_Basket.setPosition(100);