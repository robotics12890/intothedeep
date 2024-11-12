package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "A4/F3 to A1/F6 v4", group = "Robot")
public class A4_1_F3_6_Auto extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode(){
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(20,0.5);
        robot.strafeLeft(120,0.5);
        robot.strafeRight(120,0.5);
        robot.strafeRight(210,0.5);
        robot.driveBackward(15,0.5);
        //this starts in a3/f3 and strafes into a6/f1 then a1/f6 after driving slightly forward to avoid scraping the wall.
        //3 tiles
    }
}
