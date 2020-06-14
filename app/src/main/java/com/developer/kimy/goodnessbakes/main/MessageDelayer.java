package com.developer.kimy.goodnessbakes.main;

import android.content.Context;
import android.support.annotation.Nullable;

import com.developer.kimy.goodnessbakes.data.model.RecipeModel;
import com.developer.kimy.goodnessbakes.main.IdlingResource.RecipeIdlingResource;

import java.util.List;

public class MessageDelayer {

    private static final int DELAY_MILLIS = 5000;

    interface DelayerCallback {
        void onDone(List<RecipeModel> mRecipe);
    }


    static void processMessage(final String message, final DelayerCallback callback,
                               @Nullable final RecipeIdlingResource idlingResource, Context context) {
        // The IdlingResource is null in production.
        if (idlingResource != null) {
            idlingResource.setIdleState(false);
        }

        // Delay the execution, return message via callback.
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed( ()-> {

            if(idlingResource != null) {
                idlingResource.setIdleState(true);
            }

        }, DELAY_MILLIS);


//        try {
//            RecipeRepository.getInstance().getRecipeData(context);
//            RecipeRepository.getInstance().getRecipeSet(context);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
