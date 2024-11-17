package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Extra A5/F2 to A1/F6 v30 ", group = "Robot")
public class Extra_A5_1_F2_6 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(10,0.5);
        robot.strafeLeft(60,0.5);
        robot.strafeRight(60,0.5);
        robot.driveForward(80,0.25);
        robot.strafeLeft(15,0.25);
        robot.strafeRight(7,0.25);
        robot.driveForward(50,0.25);
        robot.strafeLeft(25,0.25);
        robot.driveBackward(135,0.25);
        robot.driveForward(140,0.25);
        robot.strafeLeft(25,0.25);
        robot.driveBackward(130,0.4);
//        robot.driveForward(50,0.5);
//        robot.driveBackward(30,0.5);
        robot.driveForward(5,0.5);
       robot.strafeRight(306, 0.5);
        robot.driveBackward(15,0.5);
        //This strafes from a5/f2 to a6/f1 then a1/f6 after driving slightly forward to avoid scraping the wall.
        //4 tiles
    }
}

