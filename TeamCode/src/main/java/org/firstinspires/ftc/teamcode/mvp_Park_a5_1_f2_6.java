package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Robot: Park A5/F2 to A1/F6 v3", group = "Robot")
public class mvp_Park_a5_1_f2_6 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(7,1);
        robot.strafeLeft(60,1);
        robot.strafeRight(60,1);
        robot.strafeRight(240, 1);
        //This strafes from a5/f2 to a6/f1 then a1/f6 after driving slightly forward to avoid scraping the wall.
        //4 tiles
    }
}