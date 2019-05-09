package com.smartdroidesign.searchview.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.smartdroidesign.searchview.R;

class ViewHolder extends RecyclerView.ViewHolder {

    AppCompatTextView tvName;

    ViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name);
    }
}
