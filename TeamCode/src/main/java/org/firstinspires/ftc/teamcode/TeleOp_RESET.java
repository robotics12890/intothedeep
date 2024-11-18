/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "TeleOp_RESET_1", group = "Linear OpMode")
public class TeleOp_RESET extends LinearOpMode {

    Robot robot = new Robot();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        robot.leadScrewMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Map Controls
            boolean wristNeutralButtonPressed = gamepad2.dpad_down;
            double scissorLiftControl = gamepad2.left_stick_y;
            double extensionControl = gamepad2.right_stick_y;
            boolean wristUpButtonPressed = gamepad2.dpad_up;
            boolean wristDownButtonPressed = gamepad2.dpad_right;
            boolean tiltUpButtonPressed = gamepad2.right_bumper;
            boolean tiltDownButtonPressed = gamepad2.left_bumper;

            double extensionPower = extensionControl;


            // Show the elapsed game time and wheel power.
            telemetry.addData("scissor ", robot.leadScrewMotor.getCurrentPosition());
            telemetry.addData("Extension ",robot.extensionMotor.getCurrentPosition());
            telemetry.update();

            if (wristUpButtonPressed) {
                robot.wristDown();
                robot.wristUp();
                robot.tilterUp();
            }

            if (wristDownButtonPressed) {
                robot.wristUp();
                robot.wristDown();
                robot.tilterDown();
            }

            if (wristNeutralButtonPressed)
                robot.wristNeutral();

            if (scissorLiftControl > 0 ) {
                robot.leadScrewMotor.setPower(Math.abs(scissorLiftControl));
            } else if  (scissorLiftControl < 0)
                robot.leadScrewMotor.setPower(-(Math.abs(scissorLiftControl)));
            else {
                robot.leadScrewMotor.setPower(0);
            }

            if (extensionControl > 0) {
                robot.extendLinearSlide(extensionPower);
            } else if (extensionControl < 0){
                robot.retractLinearSlide(extensionPower);
            }else {
                robot.extensionMotor.setPower(0);
            }

            if (tiltUpButtonPressed) {
                robot.tilterUp();
            }
            if (tiltDownButtonPressed) {
                robot.tilterDown();
            }

            if(gamepad2.back){
                robot.leadScrewMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }
    }
}
