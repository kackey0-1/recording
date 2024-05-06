import {apiUrl} from "@/constants/api";
import {zBookRecords} from "@/app/records/type";

export const getBookRecords = async () => {
  try {
    const res = await fetch(`${apiUrl}/records`, {cache: 'no-store'});
    const data = await res.json();
    return zBookRecords.parse(data);
  } catch (error) {
    console.error('Error occurred in getNotes:', error);
    // Handle the error appropriately here, e.g., return an empty array
    return [];
  }
};
