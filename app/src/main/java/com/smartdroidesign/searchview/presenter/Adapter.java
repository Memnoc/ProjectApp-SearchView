package com.smartdroidesign.searchview.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartdroidesign.searchview.R;
import com.smartdroidesign.searchview.model.Name;

import java.util.ArrayList;


import android.widget.Filter;
import android.widget.Filterable;

public class Adapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

    private Context context;
    private ArrayList<Name> nameList;
    private ArrayList<Name> filteredNameList;

    public Adapter(Context context, ArrayList<Name> nameList) {
        this.context = context;
        this.nameList = nameList;
        this.filteredNameList = new ArrayList<>(nameList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(filteredNameList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return filteredNameList.size();
    }

    /**
     * <p>Returns a filter that can be used to constrain data with a filtering
     * pattern.</p>
     *
     * <p>This method is usually implemented by {@link Adapter}
     * classes.</p>
     *
     * @return a filter used to constrain data
     */
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charSequenceString = constraint.toString().toLowerCase();
                if (charSequenceString.isEmpty()) {
                    filteredNameList = nameList;
                } else {
                    ArrayList<Name> filteredList = new ArrayList<>();
                    for (Name name : nameList) {
                        if (name.getName().toLowerCase().contains(charSequenceString.toLowerCase().trim())) {
                            filteredList.add(name);
                        }
                        filteredNameList = filteredList;
                    }

                }
                FilterResults results = new FilterResults();
                results.values = filteredNameList;
                return results;
            }

            @Override
            @SuppressWarnings("unchecked")
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredNameList = (ArrayList<Name>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
