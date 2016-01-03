package com.example.parktrak;
import android.app.IntentService;
import android.content.Intent;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

/**
 * Service that receives ActivityRecognition updates. It receives updates
 * in the background, even if the main Activity is not visible.
 */
public class ActivityRecognitionIntentService extends IntentService { 
  public ActivityRecognitionIntentService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

//..
  /**
     * Called when a new activity detection update is available.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
         //...
          // If the intent contains an update
        if (ActivityRecognitionResult.hasResult(intent)) {
            // Get the update
            ActivityRecognitionResult result =
              ActivityRecognitionResult.extractResult(intent);

             DetectedActivity mostProbableActivity
                    = result.getMostProbableActivity();

             // Get the confidence % (probability)
            int confidence = mostProbableActivity.getConfidence();

            // Get the type
            int activityType = mostProbableActivity.getType();
            
            String messageString = "ActivityType: " + activityType + " Confidence : " + confidence;

          //inside ActivityRecognitionIntentService 's onHandleIntent
            Intent broadcastIntent = new Intent("update-received");
            broadcastIntent.putExtra("message", messageString);

        }
    }
}