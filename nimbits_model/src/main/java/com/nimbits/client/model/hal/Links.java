
package com.nimbits.client.model.hal;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Links implements Serializable {

    @Expose
    private Self self;

    @Expose
    private Series series;

    @Expose
    private Snapshot snapshot;

    @Expose
    private DataTable datatable;

    @Expose
    private Parent parent;

    @Expose
    private Sample sample;

    @Expose
    private Next next;

    public Links() {
    }

    public Links(Self self, Parent parent, Series series, Snapshot snapshot, DataTable datatable, Next next ) {
        this.self = self;
        this.series = series;
        this.snapshot = snapshot;
        this.datatable = datatable;
        this.parent = parent;
        this.next = next;
    }

    public Links(Self self, Parent parent, Sample sample) {
        this.self = self;
        this.sample = sample;
        this.parent = parent;
    }



}
