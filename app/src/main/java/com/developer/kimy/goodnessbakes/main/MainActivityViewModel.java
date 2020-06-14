package com.developer.kimy.goodnessbakes.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.developer.kimy.goodnessbakes.data.RecipeRepository;
import com.developer.kimy.goodnessbakes.data.model.RecipeModel;
import com.developer.kimy.goodnessbakes.utils.GsonInstance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivityViewModel extends AndroidViewModel{

    private RecipeRepository recipeRepository;
    private List<RecipeModel> model;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Initialization method for ViewModel
     * This methods gets the recipe data and assign it to the repository variable
     */
    void init() {

        recipeRepository = RecipeRepository.getInstance();

    }


    List<RecipeModel> getRecipeData() {

        if(model == null) {

            model = new ArrayList<>();

            try {
                recipeRepository.getRecipeData(getApplication().getApplicationContext());

                Set<String> set = recipeRepository.getRecipeSet(getApplication().getApplicationContext());
                if(set != null) {
                    for (String data : set) {
                        model.add(GsonInstance.getGsonInstance().fromJson(data, RecipeModel.class));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (model == null) {
                Log.e("MainActivityViewModel", "model is empty");
            }

        }


        return model;
    }

}
