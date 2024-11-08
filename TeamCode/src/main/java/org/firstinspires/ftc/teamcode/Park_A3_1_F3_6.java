package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Park A4/F3 to A1/F6 Park v1", group = "Robot")
public class Park_A3_1_F3_6 extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode(){
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(20,0.5);
        robot.strafeRight(180,0.5);
        //this starts in a3/f3 and strafes into a1/f6 after driving slightly forward to avoid scraping the wall.
        //3 tiles
    }
}

