/* PlaceDetail.java
 * Electric Sheep - K.Hall, C.Munoz, A.Reaves
 * Class used to hold GooglePlace Detail data 
 */

/* Changes by Saturday Night Special:
 * 
 * Brian: added a rating string and modified jsonToPlaceDetail to get
 * the rating from the JSON object.
 */

package com.android.electricsheep.townportal;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;

public class PlaceDetail {

	private String phoneNumber = null;
	private String address = null;
	private String website = null;
	private String photoRef = null;
	private String siteName = null;
	private String rating = null; //variable addition - SNS
	private Bitmap sitePhoto = null;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhotoRef() {
		return photoRef;
	}

	public void setPhotoRef(String photoRef) {
		this.photoRef = photoRef;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	static PlaceDetail jsonToPlaceDetail(JSONObject result) {
		
		PlaceDetail placeDetail = null;
		try {
			placeDetail = new PlaceDetail();

			if (!(result.isNull("photos"))) {
				JSONArray photos = result.getJSONArray("photos");
				JSONObject photo = photos.getJSONObject(0);
				placeDetail.setPhotoRef(photo.getString("photo_reference"));
			}

			if(!(result.isNull("formatted_phone_number"))) {
				String phoneNumber = result.getString("formatted_phone_number");
				placeDetail.setPhoneNumber(phoneNumber);
			}

			if(!(result.isNull("formatted_address"))) {
				String address = result.getString("formatted_address");
				placeDetail.setAddress(address);
			}

			if(!(result.isNull("website"))) {
				String website = result.getString("website");
				placeDetail.setWebsite(website);
			}

			if(!(result.isNull("name"))) {
				String siteName = result.getString("name");
				placeDetail.setSiteName(siteName);
			}
			
			//SNS-Joe Sweat: Now will grab the number switch it to a string and send it through.
			if(!(result.isNull("rating"))) {
				Double rtn = result.getDouble("rating");
                       		String rating = "Average google Rating: " + Double.toString(rtn);
                                placeDetail.setRating(rating);
			}

		} catch (JSONException ex) {
			Logger.getLogger(Place.class.getName()).log(Level.SEVERE, null, ex);
		}
		return placeDetail;
	}

	public Bitmap getSitePhoto() {
		return sitePhoto;
	}

	public void setSitePhoto(Bitmap sitePhoto) {
		this.sitePhoto = sitePhoto;
	}
	
	//additional getter/setter methods - SNS
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}

}
