package com.mhacks.speakeasy;

import com.mhacks.speakeasy.models.*;

/**
 * Created by Jason on 9/12/2015.
 */
public class ParseAccess {

    Recording StoreRecording(String objectId) { return new Recording();}
    Report GetRawReport(String objectId) { return new Report(); }

}
