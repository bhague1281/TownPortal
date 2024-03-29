/* PlacePhoto.java
 * Electric Sheep - K.Hall, C.Munoz, A.Reaves
 * Class used to hold GooglePlace Photo data 
 */

package com.android.electricsheep.townportal;

import android.graphics.Bitmap;

public class PlacePhoto {

	private String photoReference;
	private Bitmap photo;

	public String getPhotoReference() {
		return photoReference;
	}

	public void setPhotoReference(String photoReference) {
		this.photoReference = photoReference;
	}

	public Bitmap getPhoto() {
		return photo;
	}

	public void setPhoto(Bitmap photo) {
		this.photo = photo;
	}

}
