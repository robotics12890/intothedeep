package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Robot: mvp Park a3/f4 to a1/f6 v2", group = "Robot")
public class mvp_Park_a3_1_f4_6 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        robot.strafeRight(120, 1);
        // this goes from a3/f4 to f6/a1
        //2 tiles
    }
}