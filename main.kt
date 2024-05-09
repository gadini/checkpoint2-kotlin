package carreiras.com.github.listadecompras.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import carreiras.com.github.listadecompras.R;
import carreiras.com.github.listadecompras.model.ItemModel;

/**
 * Adapter para exibir uma lista de itens em um RecyclerView.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private final List<ItemModel> items = new ArrayList<>();

    /**
     * Adiciona um novo item à lista e atualiza o RecyclerView.
     *
     * @param newItem O novo item a ser adicionado.
     */
    public void addItem(ItemModel newItem) {
        items.add(newItem);
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ItemModel item = items.get(position);
        holder.bind(item);
    }

    /**
     * ViewHolder para exibir cada item na RecyclerView.
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ItemViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textViewItem);
        }

        /**
         * Liga um item ao ViewHolder.
         *
         * @param item O item a ser vinculado.
         */
        public void bind(ItemModel item) {
            textView.setText(item.getName());
        }
    }
}
