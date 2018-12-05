//This is a program for sampling **Does not have a sensor programmed in**

package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous (name = "Simpile Sampling")
public class Simple_Sampling extends LinearOpMode {

    public DcMotor M1_BLW;
    public DcMotor M2_BRW;
    public ColorSensor Sen1_CS;

    @Override
    public void runOpMode() throws InterruptedException{

        M1_BLW = hardwareMap.get(DcMotor.class, "M1_BLW");
        M2_BRW = hardwareMap.get(DcMotor.class, "M2_BRW");
        Sen1_CS = hardwareMap.get(ColorSensor.class, "Sen1_CS");

        M1_BLW.setDirection(DcMotor.Direction.FORWARD);
        M2_BRW.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        while(opModeIsActive()){

            M1_BLW.setPower(.5);
            M2_BRW.setPower(.5);
            sleep(100);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(1);
            M2_BRW.setPower(.3);
            sleep(750);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(.1);
            M2_BRW.setPower(.1);
            sleep(500);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            sleep(2000); //Symbolizing the sensing


            //"SAW A GOLD"

            M1_BLW.setPower(1);
            M2_BRW.setPower(1);
            sleep(600);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);
            

            //"SAW A SILVER"

            M1_BLW.setPower(0);
            M2_BRW.setPower(-1);
            sleep(700);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(1);
            M2_BRW.setPower(1);
            sleep(800);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            return;

        }
    }
}
