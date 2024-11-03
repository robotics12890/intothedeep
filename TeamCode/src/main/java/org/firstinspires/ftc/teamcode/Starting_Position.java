package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Starting Position", group = "Robot")
public class Starting_Position extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode() {
    robot.init(hardwareMap);
        waitForStart();

        robot.wristNeutral();
    }
}
