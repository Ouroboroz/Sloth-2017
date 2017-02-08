package vision;

import org.opencv.core.*;
import org.opencv.core.Core.*;
import org.opencv.imgproc.*;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;
public class Vision {
	Mat source = new Mat();
	public boolean run(){
		CameraServer.getInstance().startAutomaticCapture("VisionCam", 0);
		CvSink cvSink = CameraServer.getInstance().getVideo("VisionCam");
		CvSource outputStream = CameraServer.getInstance().putVideo("TestOutput", 640, 480);
		cvSink.grabFrame(source);
		return true;
	}
}
