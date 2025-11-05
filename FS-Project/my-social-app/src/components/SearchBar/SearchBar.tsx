import React, { useState, useEffect, useRef } from "react";
import { useNavigate } from "react-router-dom";
import "./SearchBar.css";
import axios from "axios";

interface UserDTO {
  username: string;
  name: string; // optional, if available
}

type Props = {};

export default function SearchBar({}: Props) {
  const [query, setQuery] = useState("");
  const [suggestions, setSuggestions] = useState<UserDTO[]>([]);
  const [showDropdown, setShowDropdown] = useState(false);
  const navigate = useNavigate();
  const wrapperRef = useRef(null);

  useEffect(() => {
    if (query.length === 0) {
      setSuggestions([]);
      return;
    }

    const delayDebounce = setTimeout(() => {
      axios
        .get(`http://localhost:8080/api/users/search?query=${query}`)
        .then((res) => {
          setSuggestions(res.data);
          console.log(res.data);
          setShowDropdown(true);
        })
        .catch((err) => {
          console.error("Error fetching users:", err);
        });
    }, 300); // debounce API calls

    return () => clearTimeout(delayDebounce);
  }, [query]);

  // Hide dropdown on outside click
  useEffect(() => {
    function handleClickOutside(event: MouseEvent) {
      if (
        wrapperRef.current &&
        !(wrapperRef.current as any).contains(event.target)
      ) {
        setShowDropdown(false);
      }
    }
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  return (
    <div className="search-section" ref={wrapperRef}>
      <div className="search_bar">
        <input
          type="text"
          placeholder="Search by username"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
        />
        <button onClick={() => setQuery("")}>🔍</button>
      </div>

      {showDropdown && suggestions.length > 0 && (
        <ul className="search-dropdown">
          {suggestions.map((user, index) => (
            <li
              key={index}
              onClick={() => {
                navigate(`/OtherUserProfile/${user.username}`);
                setShowDropdown(false);
                setQuery("");
              }}
            >
              <img
                src={user.profileImageUrl || "/default-profile.png"}
                className="dropdown-profile-img"
              />
              @{user.username}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
