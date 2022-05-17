package moola.phucpt.recipesexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IOnItemClickListener {
    private RecyclerView lstRecipe;
    private RecipeAdapter mAdapter;
    private final LinkedList<Recipe> recipes = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeData();

        lstRecipe = findViewById(R.id.lstRecipe);
        mAdapter = new RecipeAdapter(this, recipes);
        lstRecipe.setAdapter(mAdapter);
        lstRecipe.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initializeData() {
        for (int i = 0; i < 10; i++) {
            String title = "Recipe " + (i + 1);
            String description = "Description " + (i + 1);
            String content = "Content " + (i + 1);
            Recipe recipe = new Recipe(title, description, content);
            recipes.add(recipe);
        }
    }

    public void openRecipeDetail(Recipe recipe) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", recipe);
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void onItemClicked(int position) {
        Recipe recipe = mAdapter.mRecipe.get(position);
        openRecipeDetail(recipe);
    }
}