package com.example.nesrine.e_learning;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.support.annotation.Dimension;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;

public class CommencerConf extends AppCompatActivity {

    //check orientation for output image
    private static  final SparseIntArray orientation = new SparseIntArray();
    static {

        orientation.append(Surface.ROTATION_0,90);
        orientation.append(Surface.ROTATION_90,0);
        orientation.append(Surface.ROTATION_180,270);
        orientation.append(Surface.ROTATION_270,180);
        orientation.append(Surface.ROTATION_180,270);
    }
    private String cameraId;
    private CameraDevice cameraDevice;
    private CameraCaptureSession cameraCaptureSession;
    private CaptureRequest.Builder captureRequestBuilder;
    private Size imageDimension;
    private ImageReader imageReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commencer_conf);
    }
}
