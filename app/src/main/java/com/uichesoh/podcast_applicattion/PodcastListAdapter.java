package com.uichesoh.podcast_applicattion;

import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.uichesoh.podcast_applicattion.databinding.FragmentPodcastListBinding;
import com.uichesoh.podcast_applicattion.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PodcastListAdapter extends RecyclerView.Adapter<PodcastListAdapter.ViewHolder> implements ListAdapter {

    private final List<ItunesResponse.Welcome> podcastList;

    public PodcastListAdapter(List<ItunesResponse.Welcome> items) {
        podcastList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPodcastListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = podcastList.get(position);
        holder.mIdView.setText(podcastList.get(position).toString());
        holder.mContentView.setText(podcastList.get(position).getFeed().getTitle().toString());
    }

    @Override
    public int getItemCount() {
        return podcastList.size();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public ItunesResponse.Welcome mItem;

        public ViewHolder(FragmentPodcastListBinding binding) {
            super(binding.getRoot());
            mIdView = binding.textViewPodcastTitle;
            mContentView = binding.textViewPodcastAuthor;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}