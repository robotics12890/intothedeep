package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "Park A5/F2 to A2/F5 v3", group = "Robot")
public class Park_A5_2_F2_5 extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(20,0.5);
        robot.strafeRight(210,0.5);
        robot.driveBackward(15,0.5);
        //This strafes from a5/f2 to a6/f1 then a2/f5 after driving slightly forward to avoid scraping the wall.
        //3 tiles
    }
}
