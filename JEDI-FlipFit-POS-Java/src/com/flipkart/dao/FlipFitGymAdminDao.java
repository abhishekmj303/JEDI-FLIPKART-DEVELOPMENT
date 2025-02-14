package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymAdmin;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGymCenter;
import java.util.List;

public interface FlipFitGymAdminDao {
    
    void addGymAdmin(FlipFitGymAdmin admin);
    
    boolean approveGymOwner(int ownerId);
    
    boolean approveGymCentre(int centreId);
    
    List<FlipFitGymCenter> listAllGymCentres();
}
