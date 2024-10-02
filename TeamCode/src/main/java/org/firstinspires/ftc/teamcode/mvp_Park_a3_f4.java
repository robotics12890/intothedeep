package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Robot: mvp Park a3/f4 red v1", group = "Robot")
public class mvp_Park_a3_f4 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();
        robot.strafeRight(48, 1);
    }
}