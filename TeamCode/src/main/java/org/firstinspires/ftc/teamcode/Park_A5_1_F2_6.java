package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Park A5/F2 to A1/F6 v1", group = "Robot")
public class Park_A5_1_F2_6 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(20,0.5);
        robot.strafeRight(240, 0.5);
        //This strafes from a5/f2 to a6/f1 then a1/f6 after driving slightly forward to avoid scraping the wall.
        //4 tiles
    }
}
