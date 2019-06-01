package dk.aiae.inventorymanagementandroid;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import io.swagger.client.model.ProductArray;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private static final String TAG = "ProductAdapter";

    private ProductArray mProducts;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewProductName;
        private final TextView textViewProductAmount;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            textViewProductName = (TextView) v.findViewById(R.id.textViewProductName);
            textViewProductAmount = (TextView) v.findViewById(R.id.textViewProductAmount);
        }

        public TextView getTextViewProductName() {
            return textViewProductName;
        }
        public TextView getTextProductAmount(){
            return textViewProductAmount;
        }
    }

    public ProductAdapter(ProductArray product) {
        mProducts = product;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTextViewProductName().setText(mProducts.get(position).getName());
        viewHolder.getTextProductAmount().setText(mProducts.get(position).getAmount().toString());
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }
}
