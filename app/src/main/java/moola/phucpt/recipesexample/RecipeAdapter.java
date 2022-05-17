package moola.phucpt.recipesexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

/**
 * Created by Phucpt on 16/05/2022 at 23:07
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private final Context context;
    final LinkedList<Recipe> mRecipe;
    private IOnItemClickListener onItemClickListener;

    public RecipeAdapter(Context context, LinkedList<Recipe> mRecipe) {
        this.context = context;
        this.mRecipe = mRecipe;
        this.onItemClickListener = (IOnItemClickListener)context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return mRecipe.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtTitle;
        private final TextView txtDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            itemView.setOnClickListener(view -> {
                onItemClickListener.onItemClicked(getAdapterPosition());
            });
        }

        public void bindView(int position) {
            Recipe recipe = RecipeAdapter.this.mRecipe.get(position);
            txtTitle.setText(recipe.title);
            txtDescription.setText(recipe.description);
        }
    }
}
