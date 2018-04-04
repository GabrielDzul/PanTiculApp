package com.kokomusoft.panticul.listAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kokomusoft.panticul.R;
import com.kokomusoft.panticul.model.Proposal;

import java.util.ArrayList;

/**
 * Created by Gabriel on 19/04/2015.
 */
public class ProposalListAdapter extends BaseAdapter {
    protected Activity activity;
    ArrayList<Proposal> proposals;

    public ProposalListAdapter(Activity activity, ArrayList<Proposal> proposals) {
        this.activity = activity;
        this.proposals = proposals;
    }

    @Override
    public int getCount() {
        return proposals.size();
    }

    @Override
    public Object getItem(int position) {
        return proposals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Proposal proposal;
        //viewHolder object
        ProposalsViewHolder viewHolder;
        //Generate a convertview for efficiency
        View view = convertView;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE );
            view = inflater.inflate(R.layout.list_style_orange, null);

            viewHolder = new ProposalsViewHolder();
            viewHolder.image = (ImageView)view.findViewById(R.id.listItemIcon);
            viewHolder.title = (TextView)view.findViewById(R.id.listItemTitle);
            viewHolder.description = (TextView)view.findViewById(R.id.listItemDescription);
            view.setTag(viewHolder);

        }

        //Create a proposal Object
        proposal = proposals.get(position);
        //Fill the information with the shoeStoreViewHolder
        viewHolder = (ProposalsViewHolder)view.getTag();
        viewHolder.image.setImageDrawable(proposal.getImage());
        viewHolder.title.setText(proposal.getTitle());
        viewHolder.description.setText(proposal.getDescription());
        return view;
    }

    private static class ProposalsViewHolder {
        public TextView title;
        public TextView description;
        public ImageView image;
    }

}
