// MediaManager.ts
import axios from 'axios';
import { toast } from 'react-toastify';

/**
 * Upload media and return its stored URL from the backend.
 * 
 * @param formData - FormData containing the file to upload
 * @param type - 'profile' | 'background' | 'post'
 * @param userData - Object containing user information { id: string, ... }
 * @param postId - Optional, for associating media with a post
 * @returns URL of the stored file from backend
 */
export const MediaManager2 = async ({
  formData,
  type,
  userData,
}: {
  formData: FormData;
  type: 'profile' | 'background' | 'post';
  userData: any;
  category?: string;
}): Promise<any | null> => {
  try {
    // Append mandatory data
    formData.append('userId', userData.id);
    formData.append('mediaType', 'ProfileImage'); // can be enhanced to support video, gif later
    console.log(formData);
    const res = await axios.post(
      'http://localhost:8082/media/profile',
      formData,
      {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }
    );
    
    
    const fileUrl = `http://localhost:8082${res.data.fileUrl}`;
    console.log("upload sucessfull "+fileUrl);

    
    
    return fileUrl;
    
  } catch (err) {
    console.error('Media upload failed:', err);
    return null;
  }
};

export default MediaManager2;