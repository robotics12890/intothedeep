package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "A4/F3 to A1/F6 v2", group = "Robot")
public class Park_A3_1_F3_6 extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode(){
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(7,1);
        robot.strafeRight(180,1);
        //this starts in a3/f3 and strafes into a1/f6 after driving slightly forward to avoid scraping the wall.
        //3 tiles
    }
}

