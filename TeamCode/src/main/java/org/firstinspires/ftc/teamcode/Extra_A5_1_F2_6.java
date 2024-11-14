package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Extra A5/F2 to A1/F6 v10", group = "Robot")
public class Extra_A5_1_F2_6 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(20,0.5);
        robot.strafeLeft(60,0.5);
        robot.strafeRight(60,0.5);
        robot.driveForward(70,0.25);
        robot.strafeLeft(20,0.25);
        robot.strafeRight(7,0.25);
        robot.driveForward(30,0.25);
        robot.strafeLeft(15,0.25);
        robot.driveBackward(110,0.25);
        robot.driveForward(105,0.25);
        robot.strafeLeft(15,0.25);
        robot.driveBackward(110,0.25);
        robot.driveForward(10,0.25);
        robot.strafeRight(76,0.25);
        robot.strafeRight(230, 0.25);
        robot.driveBackward(15,0.25);
        //This strafes from a5/f2 to a6/f1 then a1/f6 after driving slightly forward to avoid scraping the wall.
        //4 tiles
    }
}

