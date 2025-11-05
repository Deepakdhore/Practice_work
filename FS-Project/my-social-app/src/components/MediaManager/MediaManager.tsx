import React, { useState } from 'react';
import axios from 'axios';

const MediaUpload = () => {
  const [file, setFile] = useState(null);
  const [previewUrl, setPreviewUrl] = useState(null);
  const [storedUrl, setStoredUrl] = useState(null);

  const handleFileChange = e => {
    const f = e.target.files[0];
    setFile(f);
    setPreviewUrl(URL.createObjectURL(f));
    
  };

  const handleUpload = async () => {
    if (!file) return alert("Select a file");

    const formData = new FormData();
    formData.append('file', file);
    formData.append('userId', '17');
    formData.append('mediaType', 'image');

    const res = await axios.post(
      'http://localhost:8082/media',
      formData,
      { headers: { 'Content-Type': 'multipart/form-data' } }
    );

    // res.data.fileUrl === "/media/file/your-file.jpg"
    const url = `http://localhost:8082${res.data.fileUrl}`;
    setStoredUrl(url);
  };

  return (
    <div>
      <h2>Upload Media</h2>
      <input type="file" onChange={handleFileChange} />

      <button onClick={handleUpload}>Upload</button>

      {previewUrl && (
        <>
          <h3>Preview (sent):</h3>
          <img src={previewUrl} width="200" />
        </>
      )}

      {storedUrl && (
        <>
          <h3>Stored (from backend):</h3>
          <img src={storedUrl} width="200" />
          <p><a href={storedUrl} target="_blank" rel="noreferrer">{storedUrl}</a></p>
        </>
      )}
    </div>
  );
};

export default MediaUpload;
