package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Robot: Park A5/F2 to A1/F6 v2", group = "Robot")
public class mvp_Park_a5_1_f2_6 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();
        robot.strafeRight(240, 1);
        //This goes from a5/f2 to a1/f6
        //4 tiles
    }
}