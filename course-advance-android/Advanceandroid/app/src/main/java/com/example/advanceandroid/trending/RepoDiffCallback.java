package com.example.advanceandroid.trending;

import androidx.recyclerview.widget.DiffUtil;

import com.example.advanceandroid.model.Repo;

import java.util.List;

public class RepoDiffCallback extends DiffUtil.Callback {
    List<Repo> oldList;
    List<Repo> newList;

    public RepoDiffCallback(List<Repo> oldList, List<Repo> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).id() == newList.get(newItemPosition).id();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
