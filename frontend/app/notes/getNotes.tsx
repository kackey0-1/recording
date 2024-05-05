import {apiUrl} from "@/constants/api";
import {zNotes} from "@/app/notes/type";

export const getNotes = async () => {
  try {
    const res = await fetch(`${apiUrl}/notes`, {cache: 'no-store'});
    const data = await res.json();
    return zNotes.parse(data);
  } catch (error) {
    console.error('Error occurred in getNotes:', error);
    // Handle the error appropriately here, e.g., return an empty array
    return [];
  }
};
