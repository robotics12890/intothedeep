package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Park a3/f4 to a1/f6 v1", group = "Robot")
public class Park_A3_1_F4_6 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(20, 0.5);
        robot.strafeRight(120, 0.5);
        robot.driveBackward(15,0.5);
        // this goes from a3/f4 to f1/a6 then f6/a1 by strafing after driving slightly forward to avoid scraping the wall.
        //2 tiles
    }
}
