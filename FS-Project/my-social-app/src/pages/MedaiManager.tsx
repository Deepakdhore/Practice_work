import MediaUploader from "../components/MediaManager/MediaManager";

export default function ProfileEditor() {
  const handleUpload = (url: any) => {
    console.log("Profile picture URL:", url);
    // Save this URL in the user's profile backend
  };

  return (
    <div>
      <h2>Upload Profile Picture</h2>
      <MediaUploader
        userId={17}
        postId={123}
        mediaType="Profile-image"
        onUploadSuccess={(url: string) => console.log("Uploaded to:", url)}
      />
    </div>
  );
}
